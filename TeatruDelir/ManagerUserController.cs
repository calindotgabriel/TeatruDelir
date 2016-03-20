using TeatruDelir.Models;

namespace TeatruDelir
{
    public class ManagerUserController : UserController
    {
        public ManagerUserController(User found)
        {
            baseUser = found;
        }

        public void AddShow(Show show)
        {
            ShowRepository.AddShow(show);
        }
    }
}