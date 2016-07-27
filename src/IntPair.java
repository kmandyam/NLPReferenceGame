public class IntPair {
        private int leftGreater;
        private int rightGreater;

        public IntPair(int leftGreater, int rightGreater){
            this.leftGreater = leftGreater;
            this.rightGreater = rightGreater;
        }

        public int getLeft(){
            return this.leftGreater;
        }

        public int getRight(){
            return this.rightGreater;
        }

        public void incrementLeft(){
            this.leftGreater = this.leftGreater + 1;
        }

        public void incrementRight(){
            this.rightGreater = this.rightGreater + 1;
        }

        public double getRightStats(){
            if(this.getRight() != 0){
                double right = (double) this.rightGreater;
                double left = (double) this.leftGreater;
                return (right/ (right + left)) * 100;
            }
            return 0;
        }

        public double getLeftStats(){
            if(this.getLeft() != 0){
                double right = (double) this.rightGreater;
                double left = (double) this.leftGreater;
                return (right/(right + left)) * 100;
            }
            return 0;
        }

        public String toString(){
            return "(" + this.leftGreater + ", " + this.rightGreater + ")";
        }

}
