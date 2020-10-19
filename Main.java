class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}

class PeopleStats {
    private final List<Person> people;

    public PeopleStats(Path inputFilePath) {
        try {
            people = Files.lines(inputFilePath)
                    .map(line -> line.split("\t"))
                    .map(chunks -> new Person(chunks[0], chunks[1]))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}

class Person {
    private final String firstName;
	private final String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
		this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
	
	public String getLastName() {
        return lastName;
    }
}