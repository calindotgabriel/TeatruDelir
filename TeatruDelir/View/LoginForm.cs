using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using TeatruDelir.Core.Controllers;
using TeatruDelir.Domain.Exception;

namespace TeatruDelir
{
    public partial class LoginForm : Form
    {
        public LoginForm()
        {
            InitializeComponent();
            AutoCompleteTestData("admin", "admin");
        }

        private void loginButton_Click(object sender, EventArgs e)
        {
            ClearErrorMessages();
            var username = usernameTextbox.Text;
            var password = passwordTextbox.Text;
            try
            {
                var userController = Controller.LoginUser(username, password);
                this.Hide();
                if (userController.baseUser.IsManager)
                {
                    var showForm = new ManagerShowForm(userController);
                    showForm.Show();
                }
                else
                {
                    var showForm = new ClientShowForm(userController);
                    showForm.Show();
                }
            }
            catch (NoSuchUserException exception)
            {
                loginErrorLabel.Text = exception.Message;
            }
            catch (BadUserPasswordException exception)
            {
                loginErrorLabel.Text = exception.Message;
            }
        }

        private void AutoCompleteTestData(string username, string password)
        {
            usernameTextbox.Text = username;
            passwordTextbox.Text = password;
        }

        private void ClearErrorMessages()
        {
            loginErrorLabel.Text = String.Empty;
        }
    }
}
