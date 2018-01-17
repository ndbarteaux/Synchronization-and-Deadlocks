JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java

CLASSES = \
	Buffer.java \
	Consumer.java \
	Producer.java \
	ProducerConsumer.java 
	
default: all
all: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class