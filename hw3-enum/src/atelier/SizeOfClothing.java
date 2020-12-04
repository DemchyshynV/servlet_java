package atelier;

public enum SizeOfClothing {

    XXS(34){
        @Override
        public void getDescription() {                  // the same without name()
            System.out.println("size is " + SizeOfClothing.XXS.name() + ", euro size is " + this.getEuroSize());
        }
    },
    XS(36){
        @Override
        public void getDescription() {
            System.out.println("size is " + SizeOfClothing.XS.name() + ", euro size is " + this.getEuroSize());
        }
    },
    S(38){
        @Override
        public void getDescription() {
            System.out.println("size is " + SizeOfClothing.S.name() + ", euro size is " + this.getEuroSize());
        }
    },
    M(40){
        @Override
        public void getDescription() {
            System.out.println("size is " + SizeOfClothing.M.name() + ", euro size is " + this.getEuroSize());
        }
    },
    L(42){
        @Override
        public void getDescription() {
            System.out.println("size is " + SizeOfClothing.L.name() + ", euro size is " + this.getEuroSize());
        }
    };

    private int euroSize;

    SizeOfClothing(int euroSize) {
        this.euroSize = euroSize;
    }

    public int getEuroSize() {
        return euroSize;
    }

    public void setEuroSize(int euroSize) {
        this.euroSize = euroSize;
    }

    public abstract void getDescription();
}
