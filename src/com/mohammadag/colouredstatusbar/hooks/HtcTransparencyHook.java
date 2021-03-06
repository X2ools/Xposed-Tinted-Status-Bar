package com.mohammadag.colouredstatusbar.hooks;

import java.util.Locale;

import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;

public class HtcTransparencyHook {
	public static void doHook(ClassLoader classLoader) {
		if (!android.os.Build.MANUFACTURER.toLowerCase(Locale.getDefault()).contains("htc"))
			return;

		try {
			XposedHelpers.findAndHookMethod("com.android.systemui.statusbar.phone.PhoneStatusBar", classLoader,
					"setStatusBarBackground", int.class, XC_MethodReplacement.DO_NOTHING);
		} catch (Throwable t) {
			de.robv.android.xposed.XposedBridge.log("Failed to do HTC-specific hook: " + t.getMessage());
		}
	}
}
