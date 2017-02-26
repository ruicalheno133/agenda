JFLAGS = -g -d
JC = javac
DEST = Agenda
DEST2 = ~/Agenda

install:
	


	@if [ ! -d ~/Agenda ]; \
		then \
		mkdir Agenda; \
		$(JC) $(JFLAGS) $(DEST) FileManagement.java Agenda.java Main.java;\
		mv Agenda ~/;\
	else \
		echo "Directory already exists"; \
		$(JC) $(JFLAGS) $(DEST2) FileManagement.java Agenda.java Main.java;\
	fi

	@echo "Installation was Successful"

clean:
	rm *.class
	@echo "Class files removed"