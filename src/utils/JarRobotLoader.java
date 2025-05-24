package utils;

import entity.RobotModel;
import gui.MainApplicationFrame;
import log.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarRobotLoader {
	public static void loadRobotFromJar(MainApplicationFrame frame) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle(LocalizationManager.getLocalizedText("selectJarFileTitle"));
		fileChooser.setFileFilter(new FileNameExtensionFilter("JAR files", "jar"));
		int returnValue = fileChooser.showOpenDialog(frame);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			try {
				URL[] urls = {selectedFile.toURI().toURL()};
				List<String> robotClassNames = findRobotClassesInJar(selectedFile);

				if (robotClassNames.isEmpty()) {
					String noRobotsMessage = LocalizationManager.getLocalizedText("noRobotsFoundInPackage", "entity.robots");
					JOptionPane.showMessageDialog(frame, noRobotsMessage, LocalizationManager.getLocalizedText("infoTitle"), JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				String selectedClassName = (String) JOptionPane.showInputDialog(frame,
					LocalizationManager.getLocalizedText("selectRobotClassPrompt"),
					LocalizationManager.getLocalizedText("selectRobotTitle"),
					JOptionPane.QUESTION_MESSAGE, null, robotClassNames.toArray(), robotClassNames.get(0));

				if (selectedClassName != null && !selectedClassName.trim().isEmpty()) {
					try (URLClassLoader classLoader = new URLClassLoader(urls, frame.getClass().getClassLoader())) {
						Class<?> loadedClass = classLoader.loadClass(selectedClassName.trim());
						if (RobotModel.class.isAssignableFrom(loadedClass)) {
							RobotModel robot = (RobotModel) loadedClass.getDeclaredConstructor().newInstance();
							frame.setRobotModel(robot);
							Logger.info(LocalizationManager.getLocalizedText("jarLoadSuccess"));
						} else {
							JOptionPane.showMessageDialog(frame,
								LocalizationManager.getLocalizedText("classDoesNotImplementRobotModelError", selectedClassName),
								LocalizationManager.getLocalizedText("errorTitle"), JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			} catch (Exception e) {
				Logger.error(LocalizationManager.getLocalizedText("jarLoadError"));
				JOptionPane.showMessageDialog(frame,
					LocalizationManager.getLocalizedText("errorLoadingRobotFromJar", e.getMessage()),
					LocalizationManager.getLocalizedText("errorTitle"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private static List<String> findRobotClassesInJar(File jarFile) throws IOException {
		List<String> classNames = new ArrayList<>();
		String packagePath = "entity/robots/";
		try (JarFile jar = new JarFile(jarFile)) {
			jar.stream()
				.map(JarEntry::getName)
				.filter(name -> name.startsWith(packagePath) && name.endsWith(".class") && !name.contains("$"))
				.map(name -> name.substring(0, name.length() - ".class".length()).replace('/', '.'))
				.forEach(classNames::add);
		}
		return classNames;
	}
}
