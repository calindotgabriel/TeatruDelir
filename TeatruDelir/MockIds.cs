namespace TeatruDelir
{
    public class MockIds
    {
        private static int count;

        public static long GetNextId()
        {
            return count++;
        }
    }
}