package com.hook.hooker;

import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

import de.robv.android.xposed.callbacks.XC_LoadPackage;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

public class Main implements IXposedHookLoadPackage {



    private final String PACKAGE_NAME = "en.cold.jewel.th.lines";
    private boolean vvgQM33AjqPJZjX_CLIENT = false;
    private boolean vvgQM33AjqPJZjX_SERVER = false;
    private boolean OpJii28pAi06ZoYxrJlBF2gW = false;
    private boolean install = false;
    private boolean jNWow5lMF5gpMRlovjqsFg = false;

    public void hookMethods(final XC_LoadPackage.LoadPackageParam lpparam, ClassLoader newLoader, Class<?> classToHook) {

        ClassLoader classloader = lpparam.classLoader;
        if(newLoader != null) {
            classloader = newLoader;
        }

        // If we have a valid Class reference, try to hook it before using the ClassLoader

        if(classToHook != null) {
            if(!install && classToHook.getName().equals("infiltration.Main$V19")) {
                install = true;
                XposedBridge.log("[i] Installing (classToHook) hook on: infiltration.Main$V19.install(ClassLoader c, List l, File f)");
                XposedHelpers.findAndHookMethod(classToHook, "install", java.lang.ClassLoader.class, java.util.List.class, java.io.File.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("[+] install (V19) hit!");
                    }
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        hookMethods(lpparam, null, null);
                    }
                });
            } else if(!OpJii28pAi06ZoYxrJlBF2gW && classToHook.getName().equals("infiltration.oI2nTR2")) {
                OpJii28pAi06ZoYxrJlBF2gW = true;
                XposedBridge.log("[i] Installing hook (classToHook) on: infiltration.oI2nTR2.OpJii28pAi06ZoYxrJlBF2gW(String s)");
                XposedHelpers.findAndHookMethod(classToHook, "OpJii28pAi06ZoYxrJlBF2gW", String.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("[+] CLIENT (GZIP): " + param.args[0]);
                    }
                });
            } else if(!vvgQM33AjqPJZjX_SERVER && classToHook.getName().equals("infiltration.AdfdI9FaQBbbW3Hgur24m6n0")) {
                vvgQM33AjqPJZjX_SERVER = true;
                XposedBridge.log("[i] Installing hook (classToHook) on: infiltration.AdfdI9FaQBbbW3Hgur24m6n0.vvgQM33AjqPJZjX(String s, PrivateKey k)");
                XposedHelpers.findAndHookMethod(classToHook, "vvgQM33AjqPJZjX", String.class, PrivateKey.class, new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("[+] SERVER: " + param.getResult());
                    }
                });
            } else if(!vvgQM33AjqPJZjX_CLIENT && classToHook.getName().equals("infiltration.AdfdI9FaQBbbW3Hgur24m6n0")) {
                vvgQM33AjqPJZjX_CLIENT = true;
                XposedBridge.log("[i] Installing hook (classToHook) on: infiltration.AdfdI9FaQBbbW3Hgur24m6n0.vvgQM33AjqPJZjX(String s, PublicKey k)");
                XposedHelpers.findAndHookMethod(classToHook, "vvgQM33AjqPJZjX", String.class, PublicKey.class, new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("[+] CLIENT (ALL): " + param.args[0].toString());
                    }
                });
            } else if(!jNWow5lMF5gpMRlovjqsFg && classToHook.getName().equals("infiltration.AdfdI9FaQBbbW3Hgur24m6n0")) {
                jNWow5lMF5gpMRlovjqsFg = true;
                XposedBridge.log("[i] Installing hook (classToHook) on: infiltration.AdfdI9FaQBbbW3Hgur24m6n0.jNWow5lMF5gpMRlovjqsFg()");
                XposedHelpers.findAndHookMethod(classToHook, "jNWow5lMF5gpMRlovjqsFg", new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("[+] Faking root state");
                        param.setResult(false);
                    }
                });
            }
        }

        Class V19 = XposedHelpers.findClassIfExists("infiltration.Main$V19", classloader);
        if(!install && V19 != null) {
            install = true;
            XposedBridge.log("[i] Installing (classToHook) hook on: infiltration.Main$V19.install(ClassLoader c, List l, File f)");
            XposedHelpers.findAndHookMethod(V19, "install", java.lang.ClassLoader.class, java.util.List.class, java.io.File.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log("[+] install (V19) hit!");
                }
            });
        }

        Class oI2nTR2 = XposedHelpers.findClassIfExists("infiltration.oI2nTR2", classloader);
        if(!OpJii28pAi06ZoYxrJlBF2gW && oI2nTR2 != null) {
            OpJii28pAi06ZoYxrJlBF2gW = true;
            XposedBridge.log("[i] Installing hook on: infiltration.oI2nTR2.OpJii28pAi06ZoYxrJlBF2gW(String s)");
            XposedHelpers.findAndHookMethod(oI2nTR2, "OpJii28pAi06ZoYxrJlBF2gW", String.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log("[+] CLIENT (GZIP): " + param.args[0]);
                }
            });
        }

        Class AdfdI9FaQBbbW3Hgur24m6n0 = XposedHelpers.findClassIfExists("infiltration.AdfdI9FaQBbbW3Hgur24m6n0", classloader);
        if(!vvgQM33AjqPJZjX_SERVER && AdfdI9FaQBbbW3Hgur24m6n0 != null) {
            vvgQM33AjqPJZjX_SERVER = true;
            XposedBridge.log("[i] Installing hook on: infiltration.AdfdI9FaQBbbW3Hgur24m6n0.vvgQM33AjqPJZjX(String s, PrivateKey k)");
            XposedHelpers.findAndHookMethod(AdfdI9FaQBbbW3Hgur24m6n0, "vvgQM33AjqPJZjX", String.class, PrivateKey.class, new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log("[+] SERVER: " + param.getResult());
                }
            });
        }
        if(!vvgQM33AjqPJZjX_CLIENT && AdfdI9FaQBbbW3Hgur24m6n0 != null) {
            vvgQM33AjqPJZjX_CLIENT = true;
            XposedBridge.log("[i] Installing hook on: infiltration.AdfdI9FaQBbbW3Hgur24m6n0.vvgQM33AjqPJZjX(String s, PublicKey k)");
            XposedHelpers.findAndHookMethod(AdfdI9FaQBbbW3Hgur24m6n0, "vvgQM33AjqPJZjX", String.class, PublicKey.class, new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log("[+] CLIENT (ALL): " + param.args[0].toString());
                }
            });
        }
        if(!jNWow5lMF5gpMRlovjqsFg && AdfdI9FaQBbbW3Hgur24m6n0 != null) {
            jNWow5lMF5gpMRlovjqsFg = true;
            XposedBridge.log("[i] Installing hook (classToHook) on: infiltration.AdfdI9FaQBbbW3Hgur24m6n0.jNWow5lMF5gpMRlovjqsFg()");
            XposedHelpers.findAndHookMethod(AdfdI9FaQBbbW3Hgur24m6n0, "jNWow5lMF5gpMRlovjqsFg", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log("[+] Faking root state");
                    param.setResult(false);
                }
            });
        }

    }

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) {

        // Check if the target package name has been loaded

        if (!PACKAGE_NAME.isEmpty() && !lpparam.packageName.equals(PACKAGE_NAME)) {
            return;
        } else {
            XposedBridge.log("[+] Target application found: " + lpparam.packageName);
        }

        // Some protections or malware do weird tricks dynamically loading classes with:

        // java.lang.ClassLoader

        final ArrayList<String> inspectClasses = new ArrayList();
        inspectClasses.add("infiltration.Main$V19");

        Class ClassLoader = XposedHelpers.findClass("java.lang.ClassLoader", lpparam.classLoader);
        XposedHelpers.findAndHookMethod(ClassLoader, "loadClass", String.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                /*
                String className = (String) param.args[0];
                if(className.contains("infiltration")) {
                    XposedBridge.log("[!] ClassLoader.loadClass has been called: " + className);
                    hookMethods(lpparam, null);
                }
                */
                String loadedClass = (String) param.args[0];
                if(inspectClasses.contains(loadedClass)) {
                    Class<?> classToHook = (Class<?>) param.getResult();
                    if(classToHook == null) return;
                    inspectClasses.remove(loadedClass);
                    XposedBridge.log("[!] ClassLoader.loadClass has been called: " + loadedClass);
                    hookMethods(lpparam, null, classToHook);
                }
            }
        });

        // dalvik.system.BaseDexClassLoader

        Class BaseDexClassLoader = XposedHelpers.findClassIfExists("dalvik.system.BaseDexClassLoader", lpparam.classLoader);
        XposedHelpers.findAndHookConstructor(BaseDexClassLoader, String.class, File.class, String.class, ClassLoader.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                XposedBridge.log("[!] BaseDexClassLoader has been called: " + param.args[0]);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                hookMethods(lpparam, (ClassLoader) param.getResult(), null);
            }
        });

        // dalvik.system.DexFile

        Class DexFile = XposedHelpers.findClassIfExists("dalvik.system.DexFile", lpparam.classLoader);
        XposedHelpers.findAndHookMethod(DexFile, "openDexFile", String.class, String.class, int.class, new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                XposedBridge.log("[!] openDexFile has been called: " + param.args[0] + ", " + param.args[1]);
            }
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                hookMethods(lpparam, null, null);
            }
        });
        XposedHelpers.findAndHookMethod(DexFile, "loadClass", String.class, java.lang.ClassLoader.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                String className = (String) param.args[0];
                if(className.contains("infiltration")) {
                    XposedBridge.log("[!] DexFile.loadClass has been called: " + className);
                    hookMethods(lpparam, null, null);
                }
            }
        });

        // android.support.multidex.MultiDex

        Class MultiDex = XposedHelpers.findClassIfExists("android.support.multidex.MultiDex", lpparam.classLoader);
        XposedHelpers.findAndHookMethod(MultiDex, "install", android.content.Context.class, new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                XposedBridge.log("[!] MultiDex.install has been called");
                hookMethods(lpparam, null, null);
            }
        });

    }
}
