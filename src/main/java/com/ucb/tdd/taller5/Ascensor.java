package com.ucb.tdd.taller5;

public class Ascensor {

    private Character[]pisos ={'V','V','V'};
    private Character[]ascensor ={'A','V','V'};

    public void CrearPersona(int pisoactual, int pisodestino, Boolean boton)throws Exception{
        verificarUbicacionAscensorIniciodelDia();
        verificarLimitesEdificio(pisoactual);
        verificarLimitesEdificio(pisodestino);
        verificarPersonaEnPiso(pisoactual);
        asignarPiso(pisoactual);
        activarBoton(boton);
        verificarpisoactualPisoDestino(pisoactual,pisodestino);
        asignarAscensor(pisoactual,pisodestino);

        throw  new Exception();
    }

    private void asignarAscensor(int pisoactual, int pisodestino) {
        int pos=obtenerPosicionAscensor();

        if(pisoactual==(pos+1)){
            ascensor[pos]='V';
            ascensor[pisodestino-1]='A';
        }
    }

    private int obtenerPosicionAscensor() {
        for(int i=0;i< ascensor.length;i++){
            if(ascensor[i]=='A'){
                return(i);
            }

        }
        return 0;
    }

    private void verificarpisoactualPisoDestino(int pisoactual, int pisodestino) throws Exception {
        if(pisoactual==pisodestino){
            throw new Exception("el piso actual y el piso destino no pueden ser iguales");
        }
    }

    private void activarBoton(Boolean boton) throws Exception {
        if(boton!=true){
            throw new Exception("No se presionó el boton");
        }

    }

    private Boolean verificarPersonaEnPiso(int pisoactual) throws Exception {
        if(pisos[pisoactual-1]!='P'){
            throw new Exception("No hay personas en el piso "+pisoactual);
        }else{
            return true;
        }
    }


    private void asignarPiso(int piso) throws Exception {
        pisos[piso-1]='P' ;
    }

    private void verificarUbicacionAscensorIniciodelDia()throws Exception{
        if(ascensor[0]!='A'){
            throw new Exception("El ascensor no se encuentra en el primer piso");
        }
    }

    private void verificarLimitesEdificio(int piso)throws Exception {
        if(piso<1 && piso>3){
            throw new Exception("el piso "+piso+" esta fuera del limite");
        }
    }

}
