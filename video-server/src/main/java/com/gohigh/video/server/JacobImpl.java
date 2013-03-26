package com.gohigh.video.server;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComException;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class JacobImpl {
	// ����һ��word����
	private ActiveXComponent objWord;
	// �����ĸ�word���
	private Dispatch custDocprops;
	private Dispatch builtInDocProps;
	private Dispatch document;
	private Dispatch wordObject;

	public JacobImpl() {
	}

	/** */
	/**
	 * ��word�ĵ�
	 */
	public void open(String filename) {
		// ����һ��word����
		objWord = new ActiveXComponent("Word.Application");
		// Ϊwordobject�����ֵ
		wordObject = (Dispatch) (objWord.getObject()); // ��������
		// ����һ��ֻ����ʽ��word�ĵ����
		System.out.println("Version: " + objWord.getProperty("version"));
		System.out.println("Version: " + Dispatch.get(wordObject, "Version"));
		Dispatch.put(wordObject, "Visible", new Variant(false));
		// ��ȡ�ĵ�����
		Dispatch documents = objWord.getProperty("Documents").toDispatch();
		// �򿪼����ĵ�
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
	 * �ر��ĵ�
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
