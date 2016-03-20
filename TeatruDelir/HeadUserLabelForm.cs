using System;
using System.Windows.Forms;

namespace TeatruDelir
{
    public class HeadUserLabelForm : Form
    {
        private Label loginStatusHeaderLabel;
        private UserController _userController;
        private Button backButton;

        public HeadUserLabelForm(UserController userController)
        {
            _userController = userController;
            InitializeComponent();
        }

        protected HeadUserLabelForm()
        {
            
        }

        private void InitializeComponent()
        {
            this.loginStatusHeaderLabel = new System.Windows.Forms.Label();
            this.backButton = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // loginStatusHeaderLabel
            // 
            this.loginStatusHeaderLabel.AutoSize = true;
            this.loginStatusHeaderLabel.Location = new System.Drawing.Point(25, 22);
            this.loginStatusHeaderLabel.Name = "loginStatusHeaderLabel";
            this.loginStatusHeaderLabel.Size = new System.Drawing.Size(0, 13);
            this.loginStatusHeaderLabel.TabIndex = 0;
            // 
            // backButton
            // 
            this.backButton.Location = new System.Drawing.Point(28, 38);
            this.backButton.Name = "backButton";
            this.backButton.Size = new System.Drawing.Size(75, 23);
            this.backButton.TabIndex = 2;
            this.backButton.Text = "Back";
            this.backButton.UseVisualStyleBackColor = true;
            this.backButton.Click += new System.EventHandler(this.backButton_Click);
            // 
            // HeadUserLabelForm
            // 
            this.ClientSize = new System.Drawing.Size(284, 261);
            this.Controls.Add(this.loginStatusHeaderLabel);
            this.Controls.Add(this.backButton);
            this.Name = "HeadUserLabelForm";
            this.Load += new System.EventHandler(this.HeadUserLabelForm_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        private void backButton_Click(object sender, EventArgs e)
        {
            this.Hide();
            new LoginForm().Show();
        }

        private void HeadUserLabelForm_Load(object sender, System.EventArgs e)
        {
            var name = _userController.baseUser.Name;
            var role = _userController.baseUser.IsManager ? "manager" : "client";
            loginStatusHeaderLabel.Text = "Logged in as: " + name + ", role: " + role;

        }
    }
}