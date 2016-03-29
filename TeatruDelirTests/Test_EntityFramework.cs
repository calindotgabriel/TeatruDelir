// Created by Călin Gabriel
// at 5:14 PM on 29/03/2016.
//  

using Microsoft.VisualStudio.TestTools.UnitTesting;
using TeatruDelir;
using TeatruDelir.Models;
using TeatruDelir.Persistence;

namespace TeatruDelirTests
{
    [TestClass]
    public class Test_EntityFramework
    {

        [TestMethod]
        public void TestAdd()
        {
            var unitOfWork = new UnitOfWork(new DelirContext());

            unitOfWork.Users.Add(new User()
            {
                Id = MockIds.GetNextId(),
                Name = "Eusebiu",
                HashedPassword = Hasher.Hash("Carton")
            });

            unitOfWork.Complete();
            unitOfWork.Dispose();
        }
    }
}