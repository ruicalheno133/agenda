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
		cp help.txt ~/Agenda;\
	else \
		echo "Directory already exists"; \
		cp help.txt ~/Agenda;\
		$(JC) $(JFLAGS) $(DEST2) FileManagement.java Agenda.java Main.java;\
	fi

	@echo "Installation was Successful"

clean:

	@if [ ! -d ~/Agenda ]; \
		then \
		echo "Agenda does not exist";\
	else \
		rm ~/Agenda/*;\
		rmdir ~/Agenda;\
	fi

	@echo "Agenda was removed"