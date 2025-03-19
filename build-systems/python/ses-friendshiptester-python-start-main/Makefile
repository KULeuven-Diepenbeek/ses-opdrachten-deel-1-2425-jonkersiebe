MAIN = app.py
TARGET = friendshiptester.bin

compile:
	pyinstaller --onefile --name $(TARGET) $(MAIN)
	@echo "Compiling voltooid"

clean:
	-rm -R ./build/*
	-rm -R ./dist/*
	@echo "Cleaning voltooid"

test: 
	python3 $(MAIN)

run: 
	@cd ./dist && ./$(TARGET)