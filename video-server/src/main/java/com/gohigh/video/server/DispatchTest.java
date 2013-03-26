package com.gohigh.video.server;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class DispatchTest
{
  public static void main(String[] args)
  {
	  ComThread.InitMTA(true);
    ActiveXComponent xl = new ActiveXComponent("Excel.Application");
    Dispatch xlo = xl.getObject();
    try {
      System.out.println("version="+xl.getProperty("Version"));
      System.out.println("version="+Dispatch.get(xlo, "Version"));
      
      xl.setProperty("Visible", new Variant(true));
      
      Thread.sleep(3000);
      
      Dispatch workbooks = xl.getProperty("Workbooks").toDispatch();
      System.out.println("ProgramId: " + xlo.getProgramId());
      System.out.println("Workbooks: " + Dispatch.get(xlo, "Workbooks"));
//      Dispatch workbook = Dispatch.get(workbooks,"Add").toDispatch();
      Dispatch workbook = Dispatch.call(workbooks,"Add").toDispatch();
      Dispatch sheet = Dispatch.get(workbook,"ActiveSheet").toDispatch();
      Dispatch a1 = Dispatch.invoke(sheet, "Range", Dispatch.Get,
                                  new Object[] {"A1"},
                                  new int[1]).toDispatch();
      Dispatch a2 = Dispatch.invoke(sheet, "Range", Dispatch.Get,
                                  new Object[] {"A2"},
                                  new int[1]).toDispatch();
      Dispatch.put(a1, "Value", "123.456");
      Dispatch.put(a2, "Formula", "=A1*2");
      System.out.println("a1 from excel:"+Dispatch.get(a1, "Value"));
      System.out.println("a2 from excel:"+Dispatch.get(a2, "Value"));
      Variant f = new Variant(false);
      //Dispatch.call(workbook, "Close", f);
//      ComThread.Release();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if(ComThread.haveSTA) {
    	  System.out.println("STA exists");
    	  xl.invoke("Quit", new Variant[] {});
    	  ComThread.Release();
      }
    }
  }
}

