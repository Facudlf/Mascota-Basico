public class MascotaVirtual {
    private String nombre;
    private int energia;
    private int humor;
    private boolean dormida;
    private int ingestas;
    private int actividades;

    public MascotaVirtual(String nombre, int energiaInicial, int humorInicial) {
        this.nombre = nombre;
        energia = energiaInicial;
        humor = humorInicial;
        dormida = false;
        ingestas = 0;
        actividades = 0;
    }

    public String toString() {
        String estadoVivo = estaVivo() ? "viva" : "muerta";
        // Solo se puede estar durmiendo si está viva
        String estadoDormida = estaVivo() ? (estaDormido() ? "durmiendo" : "despierta") : "muerta";

        return "MascotaVirtual [Nombre: " + nombre + ", Energía: " + energia +
                ", Humor: " + humor + ", Estado: " + estadoDormida + ", Condición: " + estadoVivo + "]";
    }

    public boolean comer() {
        if (estaVivo() && !estaDormido()) {
            actividades = 0;
            ingestas += 1;
            if (energia < 100) {
                energia += (int) (energia * 0.1);
                if (energia > 100) {
                    energia = 100;
                }
            }
            if (humor == 0) {
                dormir();
            } else if (humor < 5 && ingestas < 3) {
                humor += 1;
            }
            if (ingestas >= 3){
                humor -= 1;
            }
            return true;
        }
        return false;
    }

    public boolean beber() {
        if (estaVivo() && !estaDormido()) {
            actividades = 0;
            ingestas += 1;
            if (energia < 100) {
                energia -= (int) (energia * 0.05);
                if (energia > 100) {
                    energia = 100;
                }
            }
            if (humor == 0) {
                dormir();
            } else if (humor < 5 && ingestas < 3) {
                humor += 1;
            }
            if (ingestas >= 3){
                humor -= 1;
            }
            return true;
        }
        return false;
    }

    public boolean correr() {
        if (estaVivo() && !estaDormido()){
            energia = (int) (energia - (double)(energia*0.35));
            if (energia <= 0){
                estaVivo();
            }
            if (humor == 0) {
                dormir();
            } else if (humor < 5) {
                humor -= 2;
            }
            actividades +=1;
            if (energia <= 0){
                estaVivo();
            }
            if (actividades == 3){dormir();}
            return true;
        }
        return false;
    }

    public boolean saltar() {
        if (estaVivo() && !estaDormido()){
            energia = (int) (energia - (double)(energia*0.35));
            if (energia <= 0){
                estaVivo();}
            if (humor == 0) {
                dormir();
            } else if (humor < 5) {
                humor -= 2;
            }
            actividades +=1;
            if (actividades == 3){dormir();}
            return true;
        }
        return false;
    }

    public boolean dormir() {
        if(estaVivo() && !estaDormido()) {
            if (energia < 100) {
                energia += 25;
                if (energia > 100) {
                    energia = 100;
                }
            }
            if (humor < 5) {
                humor += 1;
            }
            dormida = true;
            return true;
        }
        return false;
    }

    public boolean despertar() {
        if(estaVivo() && estaDormido()) {
            dormida = false;
            humor -= 1;
            return true;}
        return false;
    }

    public boolean estaVivo() {
        if (energia <= 0 || ingestas == 5) {
            energia = 0;
            humor = 0;
            return false;
        }
        return true;
    }

    public int getEnergia(){
        return energia;
    }

    public int getHumor(){
        return humor;
    }

    public boolean estaDormido(){
        if ((dormida || actividades == 3) && estaVivo()){
            return true;}
        return false;
    }

}


