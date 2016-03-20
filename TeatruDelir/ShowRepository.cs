using System;
using TeatruDelir.Models;

namespace TeatruDelir
{
    public class ShowRepository
    {
        private static Show _todaysShow;

        public static void AddShow(Show show)
        {
            if (!String.IsNullOrEmpty(show.Name))
            {
                _todaysShow = show;
            }
        }

        public static Show GetTodaysShow()
        {
            return _todaysShow;
        }
    }
}