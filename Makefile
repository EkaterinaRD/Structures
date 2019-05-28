all:
	javac -sourcepath ./src -d out src/MainClass.java
	java -classpath ./out MainClass
