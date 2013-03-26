package com.gohigh.video.server.jni;

import com.gohigh.video.server.info.Constant;
import com.gohigh.video.server.info.LoginInfo;
import com.gohigh.video.server.info.UserUtility;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class NativeVideoCaller {
	private Dispatch video_dispatch;
	
	public NativeVideoCaller() {
	    ActiveXComponent video = new ActiveXComponent("Excel.Application");
	    Dispatch video_dispatch = video.getObject();
	}
	
	public boolean startAOffice(LoginInfo info) {
		return Dispatch.call(video_dispatch, "StartAOffice", new Variant(info.toString())).toBoolean();
//		return false;
	}
	
	public boolean exitCQClient() {
		String userName = UserUtility.getValueByName(Constant.VIDEO_USER_KEY);
		return Dispatch.call(video_dispatch, "ExitICQClient", new Variant(userName)).toBoolean();
//		return false;
	}
	
	public boolean startViewCamera(long userid) {
		return Dispatch.call(video_dispatch, "startViewCamera", new Variant(userid)).toBoolean();
//		return false;
	}
	
	public boolean stopViewCamera(long userid) {
		return Dispatch.call(video_dispatch, "stopViewCamera", new Variant(userid)).toBoolean();
//		return false;
	}
}
