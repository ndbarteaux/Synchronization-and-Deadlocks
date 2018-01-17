# Synchronization-and-Deadlocks
Project for my Operating Systems class.

Combines aspects of synchronization and deadlocks to solve the bounded-buffer producer-consumer problem using threads. Written in Java.

# Classes Include

Buffer.java: Class to implement cicular buffer for comsumer and producer to read/write from/to.

Consumer.java: Class to create thread for the consumer and read from buffer.

Producer.java: Class to create thread for the producer and write to buffer.

ProducerConsumer.java: Driver class to run after compiling.

TO COMPILE:
	make all
	
TO RUN:
	java ProducerConsumer
	
TO CLEAN:
	make clean
