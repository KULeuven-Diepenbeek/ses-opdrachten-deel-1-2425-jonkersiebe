MAIN_CLASS = App
JAR_NAME = app.jar

compile:
	javac -d ./build *.java

jar:
	cd ./build && jar cvfe $(JAR_NAME) $(MAIN_CLASS) *


run: 
	cd ./build && java -cp "$(JAR_NAME)" $(MAIN_CLASS)

clean:
	-rm -R ./build/*