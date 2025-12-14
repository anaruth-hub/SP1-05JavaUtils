SP1-05 JavaUtils



Description: Java project (Maven) with Java Utils exercises to practice file/directory management, file reading, output file generation and NIO (walkFileTree). Includes execution both from IntelliJ and via terminal (PowerShell).



📌 Exercise statement



Project organized by exercise levels:



Level 1



Ex01: List the contents of a directory, sorted alphabetically.



Ex02: Read a .txt file and print it to the console.



Ex03: Traverse a directory tree and generate a tree.txt with the information (D/F + data).



Ex04: File reading (variant/format of level 1).



Ex05: Serialization (generation of a .ser) and associated classes.



Level 2



Ex01: List directories and files with NIO (Files.walkFileTree) showing type and date.



✨ Features



Listing directories and files (with path validation).



Alphabetical sorting of content.



Reading text files from resources (src/main/resources).



Generating output to file (tree.txt).



Traversing directories with NIO and SimpleFileVisitor.



Serialization to .ser.



🛠 Technologies



Java 21 (Eclipse Adoptium / OpenJDK)



Maven (project with pom.xml)



IntelliJ IDEA



Git + GitHub (push from terminal / GitHub Desktop)



Note: in some environments, mvn may not be available in the PATH. The project can also be run from IntelliJ or with javac/java via terminal.



🚀 Installation and Execution

1\) Clone the repository

git clone <URL\_DEL\_REPO>

cd SP1-05JavaUtils



2\) Run from IntelliJ (recommended)



Open the project (root folder with pom.xml).



Go to the class you want to run.



Right click on the file → Run.



If the exercise requires parameters (ex: path), configure it in:



Run → Edit Configurations… (or “Modify Run Configuration…”)



In Program arguments, write the path (ex: src or src/main/resources/sample.txt).



3\) Run from terminal (PowerShell)



From the root of the project.



Compile an exercise (example)

javac -d out src\\main\\java\\com\\ana\\javaUtils\\level1\\DirectoryListerEx01.java



Execute (example with argument)

java -cp out com.ana.javaUtils.level1.DirectoryListerEx01 src



▶️ Exercises and how to execute them

✅ Level 1 · Ex01: Directory lister



Class: com.ana.javaUtils.level1.DirectoryListerEx01



Arguments: a directory (ex: src)



Result: prints the content in alphabetical order.



javac -d out src\\main\\java\\com\\ana\\javaUtils\\level1\\DirectoryListerEx01.java

java -cp out com.ana.javaUtils.level1.DirectoryListerEx01 src



✅ Level 1 · Ex02: FileReader (sample.txt)



Class: com.ana.javaUtils.level1.FileReaderExampleEx02



File: src/main/resources/sample.txt



Arguments: path to .txt



Result: prints all contents to console.



javac -d out src\\main\\java\\com\\ana\\javaUtils\\level1\\FileReaderExampleEx02.java

java -cp out com.ana.javaUtils.level1.FileReaderExampleEx02 src\\main\\resources\\sample.txt



✅ Level 1 · Ex03: Directory tree to TXT



Class: com.ana.javaUtils.level1.DirectoryTreeToTxtEx03



Arguments: (depending on your implementation) usually source directory + name/location of the output file.



Result: generates tree.txt (in the root of the project or wherever you indicate).



Example of verifications you have already done:



dir tree.txt

Get-Content tree.txt -TotalCount 40

Select-String -Path tree.txt -Pattern " D " -SimpleMatch

Select-String -Path tree.txt -Pattern " F " -SimpleMatch



✅ Level 1 · Ex04: FileReaderEx04



Class: com.ana.javaUtils.level1.FileReaderEx04



Arguments: path to a .txt



Result: prints the complete content of the file.



✅ Level 1 · Ex05: Serialization



Classes:



com.ana.javaUtils.level1.PersonEx05



com.ana.javaUtils.level1.SerializationEx05



Result: generates a .ser file (ex: personEx05.ser).



Recommendation: the .ser is usually not versioned, because it is generated output.



✅ Level 2 · Ex01: Directory lister with NIO



Class: com.ana.javaUtils.level2.DirectoryListerNIOEx01



Arguments: directory (ex: src)



Result: prints D (directories) and F (files) with date.



javac -d out src\\main\\java\\com\\ana\\javaUtils\\level2\\DirectoryListerNIOEx01.java

java -cp out com.ana.javaUtils.level2.DirectoryListerNIOEx01 src



🧪 Tests



This project is for exercises and does not incorporate automatic tests (JUnit) at this stage.



If they are added in the future, the typical execution would be:



IntelliJ: right click on /test → Run tests



Maven: mvn test (if Maven is available in the PATH)



📸 Demo



Not applicable (console project).



🧩 Diagrams and justification of technical decisions



Classic IO (java.io.File) for basic exercises (validation exists(), isDirectory(), list()), and sorting with Arrays.sort.



NIO (java.nio.file) for robust directory tree traversal with Files.walkFileTree and SimpleFileVisitor, best for:



recursive traversal



separating preVisitDirectory and visitFile



working with BasicFileAttributes (dates, etc.)



Resource files placed in src/main/resources to have them within the project and be able to version them (ex: sample.txt).



Generated outputs (out/, target/, \*.class, \*.ser, tree.txt) are ideally trac

