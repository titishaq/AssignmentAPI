{
    'name': 'Restful API Integration',
    'version': '1.0',
    'category': 'Extra Tools',
    'summary': 'Integration with Restful API for Language Entities',
    'description': """
        This module integrates with a Restful API for managing Language Entities.
    """,
    'author': 'Your Name',
    'website': 'https://www.example.com',
    'depends': ['base'],
    'data': [
        'views/analytic_account_views.xml',
        'views/database_connection.xml',
    ],
    'installable': True,
    'application': True,
    'auto_install': False,
}