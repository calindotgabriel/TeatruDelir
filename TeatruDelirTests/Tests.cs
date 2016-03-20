using System;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using TeatruDelir;
using TeatruDelir.Models;

namespace TeatruDelirTests
{
    [TestClass]
    public class Tests
    {
        [TestMethod]
        [ExpectedException(typeof(NoSuchUserException))]
        public void TestBadUsername()
        {
            Controller.LoginUser("nousersnamedlikethis", "nosuchpassword");
        }

        [TestMethod]
        [ExpectedException(typeof(BadUserPasswordException))]
        public void TestBadPassword()
        {
            Controller.LoginUser("calinxgabriel", "nosuchpassword");
        }

        [TestMethod]
        public void TestLogin()
        {
            var userController = Controller.LoginUser("calinxgabriel", "motan");
            Assert.IsNotNull(userController);
        }

        [TestMethod]
        public void TestManagerShows()
        {
            var show = new Show()
            {
                Id = MockIds.GetNextId(),
                Name = "Barac live set"
            };
            var managerUserController = new ManagerUserController(MockFactory.RandomManager());
            managerUserController.AddShow(show);
            Assert.AreEqual(show.Name, ShowRepository.GetTodaysShow().Name);
        }


        [TestMethod]
        public void TestEncryption()
        {
            var md5ed = Hasher.Hash("carton");
            Assert.AreEqual(md5ed, Hasher.Hash("carton"));
        }
    }
}
