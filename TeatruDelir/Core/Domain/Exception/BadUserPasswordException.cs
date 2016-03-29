namespace TeatruDelir.Domain.Exception
{
    public class BadUserPasswordException : System.Exception
    {
        public BadUserPasswordException(string message) : base(message)
        {
        }
    }
}