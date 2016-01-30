package model;

public enum Size {
    S,
    M,
    L,
    XL,
    Vect,
    smallweb,
    bigweb,
    hd720,
    hd1080,
    size4k,
    EL;

    public String getXpath(){
        switch (this){
            case S:
                return ".s-2015";
            case M:
                return ".m-2015";
            case L:
                return ".l-2015";
            case XL:
                return ".xl-2015";
            case Vect:
                return ".vect";
            case smallweb:
                return ".smallweb";
            case bigweb:
                return ".bigweb";
            case hd720:
                return ".hd720";
            case hd1080:
                return ".hd1080";
            case size4k:
                return ".size-4k";
            case EL:
                return ".el0";
            default:
                throw new RuntimeException();
        }

    }
}
