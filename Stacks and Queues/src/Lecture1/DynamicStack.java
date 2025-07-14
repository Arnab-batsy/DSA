package Lecture1;

public class DynamicStack extends Stacks{

    public DynamicStack(){
        super(); //It will call Stacks
    }

    public DynamicStack(int size){
        super(size); //It will call Stacks(int size)
    }

    //Everything will remain the same except push
    //We use override since we want to use the push of this class and not the parent class

    @Override
    public boolean push(int item) {
        //This takes care of it's being full
        if(this.isFull()){
            //Double the array size
            int[] temp= new int[data.length*2];

            //Copy all previous items in new data
            System.arraycopy(data, 0, temp, 0, data.length);
            data= temp;
        }
        //At this point we know that array is not full hence we can insert the item
        return super.push(item);
    }

    //Complexity= Constant time
}
