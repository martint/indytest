Building
========

Make sure you have java 7 and maven 3 installed and run:

    mvn install

Running
=======

Run with java 7u51 to reproduce the problem:

    java -jar target/jittest-1.0-SNAPSHOT-standalone.jar


Results
=======

The run should fail with the following exception:

```
Exception in thread "main" java.lang.BootstrapMethodError: call site initialization exception
	at java.lang.invoke.CallSite.makeSite(CallSite.java:298)
	at java.lang.invoke.MethodHandleNatives.linkCallSite(MethodHandleNatives.java:295)
	at Runnable_1.run404(Unknown Source)
	at Runnable_1.run(Unknown Source)
	at com.facebook.indytest.Main.main(Main.java:8)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:134)
Caused by: java.lang.NullPointerException
	at sun.invoke.util.ValueConversions.unboxInteger(ValueConversions.java:77)
	at java.lang.invoke.CallSite.makeSite(CallSite.java:282)
	... 9 more
```