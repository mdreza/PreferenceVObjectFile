package com.altas.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
/**
 * 文件工具类
 * @author Altas
 * @email Altas.TuTu@gmail.com
 * @date 2014年9月25日
 */
public final class FileUtils {
	private static final String TAG = FileUtils.class.getSimpleName();

	public static String getAppExternalStorageDirectory() {

		File file = Environment.getExternalStorageDirectory();
		String p = file.getAbsolutePath() + File.separator + "DCIM"
				+ File.separator;
		File appFile = new File(p);
		if (!appFile.exists()) {
			appFile.mkdirs();
		}

		return appFile.getAbsolutePath();
	}

	/**
	 * 获取app的图片存放路径
	 * 
	 * @return
	 */
	public static String getAppMediaStorageDirectory() {
		File file = Environment.getExternalStorageDirectory();
		File appFile = new File(new StringBuilder()
				.append(file.getAbsolutePath()).append(File.separator)
				.append("DCIM").append(File.separator).append("Camera")
				.append(File.separator).toString());
		if (!appFile.exists()) {
			appFile.mkdirs();
		}

		return appFile.getAbsolutePath() + File.separator;
	}

	public static List<File> getFileNotRecursively(File directory, String suffix) {
		List<File> list = null;
		File[] files = directory.listFiles();
		if (files == null) {
			Log.w(TAG, "listFiles() returned null (directory: " + directory
					+ ")");
		} else {
			list = new ArrayList<File>();
			for (File file : files) {
				if ((file.isFile())
						&& (file.getName().toLowerCase().endsWith(suffix))
						&& (file.canRead())) {
					list.add(file);
				}
			}
		}
		return list;
	}

	public static <T> T readObjectFile(Context context, String fileName,
			Class<T> clazz) {
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			fileInputStream = context.openFileInput(fileName);
			objectInputStream = new ObjectInputStream(fileInputStream);
			T localObject2 = clazz.cast(objectInputStream.readObject());
			return localObject2;
		} catch (IOException e) {
			Log.e(TAG, "read file fail...", e);
		} catch (ClassNotFoundException e) {
			Log.e(TAG, "read file cast object fail...", e);
		} finally {
			IOUtils.closeSilently(fileInputStream);
			IOUtils.closeSilently(objectInputStream);
		}
		return null;
	}

	public static void writeObjectFile(Context context, String fileName,
			Object dataObject) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = context.openFileOutput(fileName, 0);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(dataObject);
			objectOutputStream.flush();
		} catch (IOException e) {
			Log.e(TAG, "write file fail...", e);
		} finally {
			IOUtils.closeSilently(objectOutputStream);
			IOUtils.closeSilently(fileOutputStream);
		}
	}
	/**
	 * 写对象文件
	 * @param file 目标文件
	 * @param dataObject 数据对象
	 */
	public static boolean writeObjectFile(File file,
			Object dataObject) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(
					file, false);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(dataObject);
			objectOutputStream.flush();
		} catch (IOException e) {
			Log.e(TAG, "write file fail...", e);
			return false;
		} finally {
			IOUtils.closeSilently(objectOutputStream);
			IOUtils.closeSilently(fileOutputStream);
		}
		return true;
	}


}