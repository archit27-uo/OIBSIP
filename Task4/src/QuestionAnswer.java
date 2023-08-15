public class QuestionAnswer {
    // Define the questions, answer choices, and correct answers as arrays
    String[] questions = {
            "Who is the Father of Java programming language?",
            "Which of the following is not a valid access modifier in Java?",
            "Which of the following is not a primitive data type in Java?",
            "Which of the following is not a valid Java identifier?",
            "Exception created by try block is caught in which block?",
            "Which keyword is used to prevent a variable from being modified in Java?",
            "Identify the infinite loop?",
            "When is the finalize() method called?",
            "What is the implicit return type of constructor?",
            "Which keyword is used to declare an interface in java?"
    };
    String[][] choices = {
            { "M.P.Java","charles Babbage", "James Gosling", "Pascal"},
            {"public", "protected", "private", "package-private"},
            {"int", "float", "string", "boolean"},
            {"myVariable", "my_variable", "_myVariable", "2myVariable"},
            {"catch", "throw", "final", "thrown"},
            {"const", "final", "static", "volatile"},
            {"for(;;)", "for()i=0;j<1;i--", "for(int=0;i++)", "All of the above"},
            {"Before garbage collection", "Before an object goes out of scope", "Before a variable goes out of scope", "None"},
            {"No return type", "A class object in which it is defined", "void", "None"},
            {"class", "interface", "implements", "abstract"}
    };
    int[] answers = {2, 3, 2, 3, 0, 1, 1, 0, 1, 1};
}
