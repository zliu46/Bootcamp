public class MemoryMap
{
    static int m_timeCalled = 0;
    static String  m_memoryString = new String ("Static Memory");
    private int m_singledimArray[];
    private int m_doubledimArray[][];

    private int m_calcField;

    public MemoryMap(int calcField)
    {
        this.m_calcField = calcField;
        this.m_singledimArray = new int[] {3,5};
        this.m_doubledimArray  = new int[][] {{1,1}, {2,2}};
        m_timeCalled ++;
        MemoryMap.m_memoryString="Revised Memory=" + calcField ;
    }

    private void calcMemorySize()
    {
        m_calcField *= 50;
    }

    private void printGoodbye()
    {
        int x=55;
        m_calcField /= 10;
        System.out.println("We are leaving");
    }

    public static void main()
    {
        int x = 45;
        MemoryMap mObj1 = new MemoryMap(50);
        MemoryMap mObj2 = new MemoryMap(30);

        mObj1.calcMemorySize();
        x+=45;
        mObj1.printGoodbye();
    }
}
