
public class UseContainers {

    public static void main(String[] args) {
        Lista<Paciente> pacienteLista = new ArrayLista<>(Paciente::compareTo);
        pacienteLista.add(new Paciente(21, "Jesus"));
        pacienteLista.add(new Paciente(22, "Pepe"));
        pacienteLista.add(new Paciente(22, "Maria"));
        pacienteLista.add(new Paciente(28, "Bob"));
        pacienteLista.add(new Paciente(18, "Jerry"));
        pacienteLista.add(new Paciente(41, "Melissa"));
        pacienteLista.add(new Paciente(34, "Cristal"));

        System.out.println(pacienteLista.toString(1));
    }



}

class Paciente implements Comparable<Paciente>{
    int age;
    String name;

    Paciente(int age, String name){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Patient called %s is %s", name, age);
    }

    @Override
    public int compareTo(Paciente paciente){
        return age == paciente.age ? name.compareTo(paciente.name) :
                age-paciente.age;
    }
}
