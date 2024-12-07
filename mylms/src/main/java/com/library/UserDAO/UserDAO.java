package com.library.UserDAO;

import com.library.User.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("ALL")
public class UserDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/mylms";
    private static final String USER = "root";
    private static final String PASSWORD = "975897";

    public UserDAO() {
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mylms", "root", "975897");
    }

    public boolean addUser(User user) {
        String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";

        try {
            Connection connection = this.getConnection();

            boolean var5;
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                try {
                    preparedStatement.setString(1, user.getName());
                    preparedStatement.setString(2, user.getEmail());
                    preparedStatement.setString(3, user.getPassword());
                    var5 = preparedStatement.executeUpdate() > 0;
                } catch (Throwable var9) {
                    if (preparedStatement != null) {
                        try {
                            preparedStatement.close();
                        } catch (Throwable var8) {
                            var9.addSuppressed(var8);
                        }
                    }

                    throw var9;
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable var10) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var7) {
                        var10.addSuppressed(var7);
                    }
                }

                throw var10;
            }

            if (connection != null) {
                connection.close();
            }

            return var5;
        } catch (SQLException var11) {
            SQLException e = var11;
            e.printStackTrace();
            return false;
        }
    }

    public User getUserById(int id) {
        String query = "SELECT * FROM users WHERE id = ?";

        try {
            Connection connection = this.getConnection();

            label78: {
                User var6;
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(query);

                    label80: {
                        try {
                            preparedStatement.setInt(1, id);
                            ResultSet resultSet = preparedStatement.executeQuery();
                            if (resultSet.next()) {
                                var6 = new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"), resultSet.getString("password"));
                                break label80;
                            }
                        } catch (Throwable var9) {
                            if (preparedStatement != null) {
                                try {
                                    preparedStatement.close();
                                } catch (Throwable var8) {
                                    var9.addSuppressed(var8);
                                }
                            }

                            throw var9;
                        }

                        if (preparedStatement != null) {
                            preparedStatement.close();
                        }
                        break label78;
                    }

                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (Throwable var10) {
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (Throwable var7) {
                            var10.addSuppressed(var7);
                        }
                    }

                    throw var10;
                }

                if (connection != null) {
                    connection.close();
                }

                return var6;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var11) {
            SQLException e = var11;
            e.printStackTrace();
        }

        return null;
    }

    public boolean updateUser(User user) {
        String query = "UPDATE users SET name = ?, email = ?, password = ? WHERE id = ?";

        try {
            Connection connection = this.getConnection();

            boolean var5;
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                try {
                    preparedStatement.setString(1, user.getName());
                    preparedStatement.setString(2, user.getEmail());
                    preparedStatement.setString(3, user.getPassword());
                    preparedStatement.setInt(4, user.getId());
                    var5 = preparedStatement.executeUpdate() > 0;
                } catch (Throwable var9) {
                    if (preparedStatement != null) {
                        try {
                            preparedStatement.close();
                        } catch (Throwable var8) {
                            var9.addSuppressed(var8);
                        }
                    }

                    throw var9;
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable var10) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var7) {
                        var10.addSuppressed(var7);
                    }
                }

                throw var10;
            }

            if (connection != null) {
                connection.close();
            }

            return var5;
        } catch (SQLException var11) {
            SQLException e = var11;
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(int id) {
        String query = "DELETE FROM users WHERE id = ?";

        try {
            Connection connection = this.getConnection();

            boolean var5;
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                try {
                    preparedStatement.setInt(1, id);
                    var5 = preparedStatement.executeUpdate() > 0;
                } catch (Throwable var9) {
                    if (preparedStatement != null) {
                        try {
                            preparedStatement.close();
                        } catch (Throwable var8) {
                            var9.addSuppressed(var8);
                        }
                    }

                    throw var9;
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Throwable var10) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var7) {
                        var10.addSuppressed(var7);
                    }
                }

                throw var10;
            }

            if (connection != null) {
                connection.close();
            }

            return var5;
        } catch (SQLException var11) {
            SQLException e = var11;
            e.printStackTrace();
            return false;
        }
    }
}