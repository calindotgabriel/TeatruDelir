namespace TeatruDelir.Models
{
    public class User
    {
        public long Id { get; set; }
        public string Name { get; set; }
        public string Address { get; set; }
        public bool IsManager { get; set; }
        public string Username { get; set; }
        public string HashedPassword { get; set; }
    }
}