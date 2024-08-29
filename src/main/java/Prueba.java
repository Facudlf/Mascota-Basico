public class Prueba {
    public static void main(String[] args) {
        MascotaVirtual miMascota = new MascotaVirtual("Jorge", 80, 1);
        System.out.println(miMascota.toString());
        miMascota.comer();
        miMascota.comer();
        miMascota.comer();
        miMascota.comer();
        System.out.println(miMascota.toString());

        MascotaVirtual miMascota2 = new MascotaVirtual("Pepito", 10,2);
        System.out.println(miMascota2.toString());
        miMascota2.comer();
        miMascota2.correr();
        System.out.println(miMascota2.toString());


    }

}
