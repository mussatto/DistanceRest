package distance;

public class CityDataBuilder {

    //by
    //https://www.google.com.br/maps/place/S%C3%A3o+Paulo,+State+of+S%C3%A3o+Paulo/@-23.6824124,-46.5952992,10z/data=!3m1!4b1!4m2!3m1!1s0x94ce448183a461d1:0x9ba94b08ff335bae?hl=en
    public static City createSaoPaulo(){
        return City.create(-23.6824124,-46.5952992,"Sao Paulo");
    }

    //by
    //https://www.google.com.br/maps/place/Rio+de+Janeiro,+State+of+Rio+de+Janeiro/@-22.9112335,-43.448334,11z/data=!3m1!4b1!4m2!3m1!1s0x9bde559108a05b:0x50dc426c672fd24e?hl=en
    public static City createRioDeJaneiro(){
        return City.create(-22.9112335,-43.448334,"Rio de Janeiro");
    }

    //by
    //https://www.google.com.br/maps/place/Bras%C3%ADlia,+Brasilia+-+Federal+District/@-15.7217621,-47.9382362,11z/data=!3m1!4b1!4m2!3m1!1s0x935a3d18df9ae275:0x738470e469754a24?hl=en
    public static City createBrasilia(){
        return City.create(-15.7217621, -47.9382362, "Brasilia");
    }
}
