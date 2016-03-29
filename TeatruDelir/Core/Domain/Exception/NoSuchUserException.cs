namespace TeatruDelir.Domain.Exception
{
    public class NoSuchUserException : System.Exception
    {
        public NoSuchUserException(string s)
            : base(s)
        {
        }
    }
}