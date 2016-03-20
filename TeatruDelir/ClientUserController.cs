using TeatruDelir.Models;

namespace TeatruDelir
{
    public class ClientUserController : UserController
    {
        public ClientUserController(User found)
        {
            baseUser = found;
        }
    }
}