using System;

namespace TeatruDelir
{
    public class NoSuchUserException : Exception
    {
        public NoSuchUserException(string s)
            : base(s)
        {
        }
    }
}