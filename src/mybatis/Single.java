package mybatis;

//public class Single {
//
//    private static volatile Single instance;
//    private Single(){
//
//    }
//
//    public static Single getInstance(){
//        if(instance==null){
//            synchronized (Single.class) {
//                if(instance==null)
//                    instance = new Single();
//            }
//        }
//        return instance;
//    }
//}

public class Single {

    private static volatile Single instance=new Single();

    private Single(){

    }

    public static Single getInstance(){
        return instance;
    }


}


