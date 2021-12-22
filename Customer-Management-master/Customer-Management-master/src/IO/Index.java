package IO;

import static Main.Quan_Ly_Gio_Hang.arr;

public class Index 
{
    public static Integer by_Id(String id)
    {
        int output = -1;
        for(int i = 0 ;i < arr.size(); i++)
        {
            if(arr.get(i).getId().equals(id))
            {
                output = i;
                break;                
            }
        }
        return output;
    }
    
    
}
