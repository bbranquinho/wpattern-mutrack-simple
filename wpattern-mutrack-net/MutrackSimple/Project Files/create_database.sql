USE [master]
GO
/****** Object:  Database [mutrack_simple]    Script Date: 20/04/2016 01:05:09 ******/
CREATE DATABASE [mutrack_simple]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'mutrack_simple', FILENAME = N'D:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\mutrack_simple.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'mutrack_simple_log', FILENAME = N'D:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\mutrack_simple_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [mutrack_simple] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [mutrack_simple].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [mutrack_simple] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [mutrack_simple] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [mutrack_simple] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [mutrack_simple] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [mutrack_simple] SET ARITHABORT OFF 
GO
ALTER DATABASE [mutrack_simple] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [mutrack_simple] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [mutrack_simple] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [mutrack_simple] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [mutrack_simple] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [mutrack_simple] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [mutrack_simple] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [mutrack_simple] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [mutrack_simple] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [mutrack_simple] SET  DISABLE_BROKER 
GO
ALTER DATABASE [mutrack_simple] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [mutrack_simple] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [mutrack_simple] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [mutrack_simple] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [mutrack_simple] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [mutrack_simple] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [mutrack_simple] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [mutrack_simple] SET RECOVERY FULL 
GO
ALTER DATABASE [mutrack_simple] SET  MULTI_USER 
GO
ALTER DATABASE [mutrack_simple] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [mutrack_simple] SET DB_CHAINING OFF 
GO
ALTER DATABASE [mutrack_simple] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [mutrack_simple] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [mutrack_simple] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'mutrack_simple', N'ON'
GO
USE [mutrack_simple]
GO
/****** Object:  Table [dbo].[tb_package]    Script Date: 20/04/2016 01:05:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_package](
	[pk_id] [int] NOT NULL,
	[name] [nchar](60) NOT NULL,
	[code] [nchar](20) NOT NULL,
	[description] [nchar](10) NULL,
	[register_date] [datetime] NOT NULL,
	[ower_id] [int] NOT NULL,
 CONSTRAINT [PK_Packages] PRIMARY KEY CLUSTERED 
(
	[pk_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tb_permission]    Script Date: 20/04/2016 01:05:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_permission](
	[pk_id] [int] NOT NULL,
	[role] [nchar](45) NOT NULL,
 CONSTRAINT [PK_Permissions] PRIMARY KEY CLUSTERED 
(
	[pk_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tb_user]    Script Date: 20/04/2016 01:05:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_user](
	[pk_id] [int] NOT NULL,
	[name] [nchar](120) NOT NULL,
	[email] [nchar](255) NOT NULL,
	[password] [nchar](128) NOT NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[pk_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tb_user_permission]    Script Date: 20/04/2016 01:05:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_user_permission](
	[permission_id] [int] NOT NULL,
	[user_id] [int] NOT NULL,
 CONSTRAINT [PK_tb_user_permission] PRIMARY KEY CLUSTERED 
(
	[permission_id] ASC,
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Index [IX_FK_tb_package_tb_user]    Script Date: 20/04/2016 01:05:09 ******/
CREATE NONCLUSTERED INDEX [IX_FK_tb_package_tb_user] ON [dbo].[tb_package]
(
	[ower_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_FK_tb_user_permission_tb_user]    Script Date: 20/04/2016 01:05:09 ******/
CREATE NONCLUSTERED INDEX [IX_FK_tb_user_permission_tb_user] ON [dbo].[tb_user_permission]
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[tb_package]  WITH CHECK ADD  CONSTRAINT [FK_tb_package_tb_user] FOREIGN KEY([ower_id])
REFERENCES [dbo].[tb_user] ([pk_id])
GO
ALTER TABLE [dbo].[tb_package] CHECK CONSTRAINT [FK_tb_package_tb_user]
GO
ALTER TABLE [dbo].[tb_user_permission]  WITH CHECK ADD  CONSTRAINT [FK_tb_user_permission_tb_permission] FOREIGN KEY([permission_id])
REFERENCES [dbo].[tb_permission] ([pk_id])
GO
ALTER TABLE [dbo].[tb_user_permission] CHECK CONSTRAINT [FK_tb_user_permission_tb_permission]
GO
ALTER TABLE [dbo].[tb_user_permission]  WITH CHECK ADD  CONSTRAINT [FK_tb_user_permission_tb_user] FOREIGN KEY([user_id])
REFERENCES [dbo].[tb_user] ([pk_id])
GO
ALTER TABLE [dbo].[tb_user_permission] CHECK CONSTRAINT [FK_tb_user_permission_tb_user]
GO
USE [master]
GO
ALTER DATABASE [mutrack_simple] SET  READ_WRITE 
GO
