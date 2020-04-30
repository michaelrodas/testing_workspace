Make ObjectSizeFetcher a jar and invoke it
(can be used in IDE as VM option)
java -javaagent:[full path to jar]ObjectSizeFetcher.jar InstrumentationExample

javac ObjectSizeFetcher.java
jar cmf MANIFEST.MF ObjectSizeFetcher.jar ObjectSizeFetcher.class