public class StringPair {
        private String left;
        private String right;

        public StringPair(String left, String right){
            this.left = left;
            this.right = right;
        }

        public String getLeft(){
            return this.left;
        }

        public String getRight(){
            return this.right;
        }

        public String toString(){
            return "(" + this.left + ", " + this.right + ")";
        }

        @Override
        public boolean equals(Object o){
            if (o instanceof StringPair) {
                StringPair op = (StringPair) o;
                if (this.getLeft().equals(op.getLeft()) && this.getRight().equals(op.getRight())) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int hashCode(){
            return (this.left.hashCode() * this.right.hashCode() * 31);
        }
}
