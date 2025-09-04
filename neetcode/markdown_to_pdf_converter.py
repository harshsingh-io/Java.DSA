#!/usr/bin/env python3
"""
DSA Notes Markdown to PDF Converter
===================================
Converts Data Structures and Algorithms markdown notes to a professional PDF
with table of contents, bookmarks, syntax highlighting, and mathematical expressions.
"""

import os
import re
import markdown
from pathlib import Path
from datetime import datetime
from weasyprint import HTML, CSS
import argparse


class DSANotesConverter:
    def __init__(self, base_path="/Users/harshsingh.io/Downloads/Dev/dsa_notes"):
        self.base_path = Path(base_path)
        self.output_path = self.base_path / "DSA_Notes_Complete.pdf"
        
        # Define the order based on the hierarchy from the image
        self.file_order = [
            # Data Structures
            ("ds/arrays.md", "Arrays"),
            ("ds/hashmaps.md", "Hash Maps"),
            ("ds/hashset.md", "Hash Sets"),
            ("patterns/two_pointers.md", "Two Pointers"),
            ("patterns/sliding_window.md", "Sliding Window"),
            ("ds/linkedlist.md", "Linked Lists"),
            ("ds/stack.md", "Stacks"),
            ("ds/priority_queue.md", "Priority Queue / Heaps"),
            ("ds/trees.md", "Trees"),
            ("ds/binary_search_tree.md", "Binary Search Trees"),
            ("ds/treemap.md", "Tree Map"),
            ("ds/treeset.md", "Tree Set"),
            ("ds/tries.md", "Tries"),
            ("ds/graph/graph.md", "Graphs"),
            
            # Algorithms
            ("algo/binary_search.md", "Binary Search"),
            ("algo/greedy_algorithm.md", "Greedy Algorithms"),
            
            # Advanced Patterns
            ("patterns/interval.md", "Interval Patterns"),
        ]
        
        # CSS styling for professional appearance
        self.css_style = """
        @import url('https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&family=JetBrains+Mono:wght@400;500&display=swap');
        
        @page {
            size: A4;
            margin: 2cm 2cm 3cm 2cm;
            
            @top-center {
                content: "DSA Notes - Complete Reference";
                font-family: 'Inter', sans-serif;
                font-size: 10pt;
                color: #6b7280;
                border-bottom: 1px solid #e5e7eb;
                padding-bottom: 8px;
            }
            
            @bottom-center {
                content: "Page " counter(page);
                font-family: 'Inter', sans-serif;
                font-size: 10pt;
                color: #6b7280;
            }
        }
        
        @page:first {
            @top-center { content: none; }
        }
        
        body {
            font-family: 'Inter', sans-serif;
            font-size: 11pt;
            line-height: 1.6;
            color: #1f2937;
            background: white;
            margin: 0;
            padding: 0;
        }
        
        /* Title Page */
        .title-page {
            text-align: center;
            padding: 8cm 0;
            page-break-after: always;
        }
        
        .title-page h1 {
            font-size: 48pt;
            font-weight: 700;
            color: #1e40af;
            margin-bottom: 1cm;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.1);
        }
        
        .title-page .subtitle {
            font-size: 18pt;
            color: #6b7280;
            margin-bottom: 2cm;
        }
        
        .title-page .date {
            font-size: 14pt;
            color: #9ca3af;
        }
        
        /* Table of Contents */
        .toc {
            page-break-after: always;
            margin-bottom: 2cm;
        }
        
        .toc h1 {
            font-size: 28pt;
            color: #1e40af;
            border-bottom: 3px solid #3b82f6;
            padding-bottom: 10px;
            margin-bottom: 1cm;
        }
        
        .toc ul {
            list-style: none;
            padding: 0;
        }
        
        .toc li {
            margin: 8px 0;
            padding: 8px 0;
            border-bottom: 1px dotted #e5e7eb;
        }
        
        .toc a {
            text-decoration: none;
            color: #374151;
            font-weight: 500;
        }
        
        .toc a:hover {
            color: #1e40af;
        }
        
        /* Headings */
        h1 {
            font-size: 24pt;
            font-weight: 700;
            color: #1e40af;
            margin: 1.5cm 0 0.8cm 0;
            padding: 15px 0;
            border-bottom: 3px solid #3b82f6;
            page-break-before: always;
        }
        
        h1:first-child {
            page-break-before: auto;
        }
        
        h2 {
            font-size: 18pt;
            font-weight: 600;
            color: #1f2937;
            margin: 1cm 0 0.5cm 0;
            padding: 10px 0;
            border-bottom: 2px solid #e5e7eb;
        }
        
        h3 {
            font-size: 14pt;
            font-weight: 600;
            color: #374151;
            margin: 0.8cm 0 0.4cm 0;
        }
        
        h4, h5, h6 {
            font-size: 12pt;
            font-weight: 500;
            color: #4b5563;
            margin: 0.6cm 0 0.3cm 0;
        }
        
        /* Paragraphs and text */
        p {
            margin: 0.4cm 0;
            text-align: justify;
        }
        
        strong, b {
            font-weight: 600;
            color: #1f2937;
        }
        
        em, i {
            font-style: italic;
            color: #374151;
        }
        
        /* Code blocks */
        pre {
            background: #f8fafc;
            border: 1px solid #e2e8f0;
            border-left: 4px solid #3b82f6;
            border-radius: 6px;
            padding: 15px;
            margin: 0.8cm 0;
            overflow-x: auto;
            font-family: 'JetBrains Mono', monospace;
            font-size: 9pt;
            line-height: 1.4;
        }
        
        code {
            font-family: 'JetBrains Mono', monospace;
            background: #f1f5f9;
            padding: 2px 6px;
            border-radius: 3px;
            font-size: 9pt;
            color: #0f172a;
        }
        
        pre code {
            background: none;
            padding: 0;
            border-radius: 0;
        }
        
        /* Tables */
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 0.8cm 0;
            box-shadow: 0 1px 3px rgba(0,0,0,0.1);
        }
        
        th {
            background: #f8fafc;
            color: #1f2937;
            font-weight: 600;
            padding: 12px;
            text-align: left;
            border: 1px solid #e2e8f0;
        }
        
        td {
            padding: 10px 12px;
            border: 1px solid #e2e8f0;
            vertical-align: top;
        }
        
        tr:nth-child(even) {
            background: #f9fafb;
        }
        
        /* Lists */
        ul, ol {
            margin: 0.4cm 0;
            padding-left: 1.2cm;
        }
        
        li {
            margin: 0.2cm 0;
        }
        
        /* Mathematical expressions */
        .math {
            font-family: 'Times New Roman', serif;
            font-style: italic;
        }
        
        /* Blockquotes */
        blockquote {
            border-left: 4px solid #10b981;
            background: #f0fdf4;
            padding: 15px 20px;
            margin: 0.8cm 0;
            border-radius: 0 6px 6px 0;
            font-style: italic;
        }
        
        /* Horizontal rules */
        hr {
            border: none;
            height: 2px;
            background: linear-gradient(to right, #3b82f6, #10b981);
            margin: 1cm 0;
            border-radius: 1px;
        }
        
        /* Utility classes */
        .page-break {
            page-break-before: always;
        }
        
        .no-break {
            page-break-inside: avoid;
        }
        
        /* Syntax highlighting for common languages */
        .highlight .k { color: #0000ff; font-weight: bold; } /* Keyword */
        .highlight .s { color: #008000; } /* String */
        .highlight .c { color: #808080; font-style: italic; } /* Comment */
        .highlight .n { color: #000000; } /* Name */
        .highlight .o { color: #666666; } /* Operator */
        """
    
    def setup_markdown_processor(self):
        """Setup markdown processor with extensions"""
        return markdown.Markdown(
            extensions=[
                'extra',
                'codehilite',
                'toc',
                'tables',
                'fenced_code',
                'admonition'
            ],
            extension_configs={
                'codehilite': {
                    'css_class': 'highlight',
                    'use_pygments': True,
                    'noclasses': False
                },
                'toc': {
                    'permalink': False
                }
            }
        )
    
    def process_math_expressions(self, content):
        """Convert LaTeX math expressions to HTML"""
        # Convert inline math $...$ to HTML
        content = re.sub(
            r'\$([^$]+)\$',
            r'<span class="math">\1</span>',
            content
        )
        
        # Convert display math $$...$$ to HTML
        content = re.sub(
            r'\$\$([^$]+)\$\$',
            r'<div class="math" style="text-align: center; margin: 1em 0;">\1</div>',
            content
        )
        
        return content
    
    def process_emojis_and_symbols(self, content):
        """Ensure emojis and special symbols are preserved"""
        # Common emoji mappings for better PDF rendering
        emoji_map = {
            '💾': '💾',
            '🎯': '🎯',
            '🐢': '🐢',
            '🐇': '🐇',
            '✅': '✅',
            '❌': '❌',
        }
        
        for emoji, replacement in emoji_map.items():
            content = content.replace(emoji, replacement)
        
        return content
    
    def read_markdown_file(self, file_path):
        """Read and return markdown file content"""
        try:
            full_path = self.base_path / file_path
            if full_path.exists():
                with open(full_path, 'r', encoding='utf-8') as f:
                    return f.read()
            else:
                print(f"Warning: File {file_path} not found")
                return None
        except Exception as e:
            print(f"Error reading {file_path}: {e}")
            return None
    
    def generate_title_page(self):
        """Generate the title page HTML"""
        return f"""
        <div class="title-page">
            <h1>Data Structures & Algorithms</h1>
            <div class="subtitle">Complete Reference Notes</div>
            <div class="date">Generated on {datetime.now().strftime('%B %d, %Y')}</div>
        </div>
        """
    
    def generate_table_of_contents(self):
        """Generate table of contents HTML"""
        toc_html = """
        <div class="toc">
            <h1>Table of Contents</h1>
            <ul>
        """
        
        for file_path, title in self.file_order:
            # Create anchor from title
            anchor = re.sub(r'[^\w\s-]', '', title).strip().replace(' ', '-').lower()
            toc_html += f'<li><a href="#{anchor}">{title}</a></li>\n'
        
        toc_html += """
            </ul>
        </div>
        """
        
        return toc_html
    
    def convert_to_pdf(self):
        """Main conversion function"""
        print("🚀 Starting DSA Notes PDF conversion...")
        
        # Setup markdown processor
        md = self.setup_markdown_processor()
        
        # Start HTML document
        html_content = f"""
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>DSA Notes - Complete Reference</title>
        </head>
        <body>
        """
        
        # Add title page
        html_content += self.generate_title_page()
        
        # Add table of contents
        html_content += self.generate_table_of_contents()
        
        # Process each file in order
        for file_path, title in self.file_order:
            print(f"📄 Processing: {title}")
            
            content = self.read_markdown_file(file_path)
            if content:
                # Create anchor for TOC linking
                anchor = re.sub(r'[^\w\s-]', '', title).strip().replace(' ', '-').lower()
                
                # Process mathematical expressions
                content = self.process_math_expressions(content)
                
                # Process emojis and symbols
                content = self.process_emojis_and_symbols(content)
                
                # Convert markdown to HTML
                html = md.convert(content)
                
                # Add section with proper heading and anchor
                html_content += f"""
                <div class="page-break" id="{anchor}">
                    <h1>{title}</h1>
                    {html}
                </div>
                """
                
                # Reset markdown processor for next file
                md.reset()
        
        # Close HTML document
        html_content += """
        </body>
        </html>
        """
        
        # Generate PDF
        print("📋 Generating PDF...")
        try:
            # Create CSS object
            css = CSS(string=self.css_style)
            
            # Generate PDF with correct API usage
            html_doc = HTML(string=html_content)
            html_doc.write_pdf(
                str(self.output_path),
                stylesheets=[css]
            )
            
            print(f"✅ PDF generated successfully: {self.output_path}")
            print(f"📊 File size: {self.output_path.stat().st_size / (1024*1024):.2f} MB")
            
        except Exception as e:
            print(f"❌ Error generating PDF: {e}")
            # Try alternative approach without font config
            try:
                print("🔄 Trying alternative PDF generation...")
                html_doc = HTML(string=html_content)
                html_doc.write_pdf(str(self.output_path))
                print(f"✅ PDF generated successfully (simplified): {self.output_path}")
                print(f"📊 File size: {self.output_path.stat().st_size / (1024*1024):.2f} MB")
            except Exception as e2:
                print(f"❌ Alternative approach also failed: {e2}")
                return False
        
        return True


def main():
    """Main function with command line argument support"""
    parser = argparse.ArgumentParser(description='Convert DSA markdown notes to PDF')
    parser.add_argument(
        '--input', '-i',
        default="/Users/harshsingh.io/Downloads/Dev/dsa_notes",
        help='Input directory containing markdown files'
    )
    parser.add_argument(
        '--output', '-o',
        help='Output PDF file path (optional)'
    )
    
    args = parser.parse_args()
    
    # Create converter instance
    converter = DSANotesConverter(args.input)
    
    # Set custom output path if provided
    if args.output:
        converter.output_path = Path(args.output)
    
    # Convert to PDF
    success = converter.convert_to_pdf()
    
    if success:
        print(f"\n🎉 Conversion completed successfully!")
        print(f"📖 Your DSA notes PDF is ready: {converter.output_path}")
    else:
        print(f"\n💥 Conversion failed. Please check the error messages above.")


if __name__ == "__main__":
    main()