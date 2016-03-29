// Created by Călin Gabriel
// at 5:09 PM on 29/03/2016.
//  

using System.Data.Entity.ModelConfiguration;
using TeatruDelir.Models;

namespace TeatruDelir.Persistence.EntityConfigurations
{
    public class UserConfiguration : EntityTypeConfiguration<User>
    {
        public UserConfiguration()
        {
            HasKey(u => u.Id);
        }        
    }
}