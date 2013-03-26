package com.gohigh.video.server;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComException;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class JacobImpl {
	// 声明一个word对象
	private ActiveXComponent objWord;
	// 声明四个word组件
	private Dispatch custDocprops;
	private Dispatch builtInDocProps;
	private Dispatch document;
	private Dispatch wordObject;

	public JacobImpl() {
	}

	/** */
	/**
	 * 打开word文挡
	 */
	public void open(String filename) {
		// 创建一个word对象
		objWord = new ActiveXComponent("Word.Application");
		// 为wordobject组件附值
		wordObject = (Dispatch) (objWord.getObject()); // 改了这里
		// 生成一个只读方式的word文挡组件
		System.out.println("Version: " + objWord.getProperty("version"));
		System.out.println("Version: " + Dispatch.get(wordObject, "Version"));
		Dispatch.put(wordObject, "Visible", new Variant(false));
		// 获取文挡属性
		Dispatch documents = objWord.getProperty("Documents").toDispatch();
		// 打开激活文挡
		document = Dispatch.call(documents, "Open", filename).toDispatch();
	}

	public void selectCustomDocumentProperitiesMode() {
		custDocprops = Dispatch.get(document, "CustomDocumentProperties").toDispatch();
	}

	public void selectBuiltinPropertiesMode() {
		builtInDocProps = Dispatch.get(document, "BuiltInDocumentProperties").toDispatch();
	}

	/** */
	/**
	 * 关闭文挡
	 */
	public void close() {
		Dispatch.call(document, "Close");
	}

	public String getCustomProperty(String cusPropName) {
		try {
			cusPropName = Dispatch.call((Dispatch) custDocprops, "Item", cusPropName).toString();
		} catch (ComException e) {
			e.printStackTrace();
			cusPropName = null;
		}
		return cusPropName;
	}

	public String getBuiltInProperty(String builtInPropName) {
		try {
			builtInPropName = Dispatch.call((Dispatch) builtInDocProps, "Item", builtInPropName).toString();
		} catch (ComException e) {
			e.printStackTrace();
			builtInPropName = null;
		}
		return builtInPropName;
	}

	public static void main(String[] args) {
		try {
			JacobImpl jacTest = new JacobImpl();
			jacTest.open("f:\\test-jacob.doc");
			jacTest.selectCustomDocumentProperitiesMode();
			jacTest.selectBuiltinPropertiesMode();
			System.out.println("before jacTest.getCustomProperty------------------");
			String custValue = jacTest.getCustomProperty("Information Source");
			System.out.println("--------" + custValue + "------------------");
			String builtInValue = jacTest.getBuiltInProperty("Author");
			jacTest.close();
			System.out.println("Document Val One:" + custValue);
			System.out.println("Document Author: " + builtInValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
