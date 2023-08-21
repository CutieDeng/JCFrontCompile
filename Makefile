# Makefile for compiling Java code

# Directories
SRC_DIR := src
OUT_DIR := out
PACKAGE := syntax
TARGET := $(PACKAGE).Entrance

# Compilation
JAVAC := javac
JAVAC_FLAGS := -d $(OUT_DIR) -sourcepath $(SRC_DIR)

# List of Java source files
JAVA_FILES := $(wildcard $(SRC_DIR)/$(PACKAGE)/*.java)

all: $(OUT_DIR) $(OUT_DIR)/$(TARGET).class

$(OUT_DIR):
	mkdir -p $(OUT_DIR)

$(OUT_DIR)/$(TARGET).class: $(JAVA_FILES)
	$(JAVAC) $(JAVAC_FLAGS) $^

run: $(OUT_DIR)/$(TARGET).class 
	java -cp out syntax.Entrance

clean:
	rm -rf $(OUT_DIR)
