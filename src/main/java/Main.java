import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main
{
    private static final Logger LOGGER=LogManager.getLogger(Main.class);
    static Scanner sc=new Scanner(System.in);

    public static void main( String[] args ) throws Exception
    {
        Customlist<Integer> customList=new Customlist<Integer>(5);
        int ch,ele,pos;

        while(true) {

            LOGGER.info("\nMenu\n1. Add Element\n2. Get Element\n3. Remove Element\n4. Pop last element\n5. Pop at a position\n6. Display elements\n7. Exit\n");
            LOGGER.info("\nEnter your choice: \n");
            ch = sc.nextInt();

            switch(ch) {
                case 1:
                    LOGGER.info("Enter an integer: \n");
                    ele = sc.nextInt();
                    customList.addElement(ele);
                    break;
                case 2:
                    LOGGER.info("Enter position(starts from 0) of element to fetch: \n");
                    pos = sc.nextInt();
                    ele = customList.getElement(pos);
                    LOGGER.info("\nThe element at position "+pos+" is "+ele+"\n");
                    break;
                case 3:
                    LOGGER.info("Enter an element to be removed: \n");
                    ele = sc.nextInt();
                    if(customList.removeElement(ele))
                        LOGGER.info("Element deleted successfully\n");
                    else
                        LOGGER.info("Element not found in the list\n");
                    break;
                case 4:
                    ele=customList.pop();
                    LOGGER.info(ele+" is deleted from the list\n");
                    break;
                case 5:
                    LOGGER.info("Enter position(strarts from 0) of element to remove: \n");
                    pos = sc.nextInt();
                    ele=customList.pop(pos);
                    LOGGER.info(ele+" is deleted from the list\n");
                    break;
                case 6:
                    customList.display();
                    break;
                case 7:
                    System.exit(0);
                default:
                    LOGGER.info("Invalid choice!!!.....Try again!!!!....");
            }

        }

    }
}