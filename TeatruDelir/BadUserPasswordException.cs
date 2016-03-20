using System;

namespace TeatruDelir
{
    public class BadUserPasswordException : Exception
    {
        public BadUserPasswordException(string message) : base(message)
        {
        }
    }
}